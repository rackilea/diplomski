public class Cube {

    private int index;
    int vertexFloatSize;
    int posOffset;
    int norOffset;
    boolean hasColor;
    int colOffset;
    private Vector3 position = new Vector3();
    private Matrix4 rotationTransform = new Matrix4().idt();
    private Color color = new Color();
    public float halfWidth, halfHeight, halfDepth;
    private boolean transformDirty = false;
    private boolean colorDirty = false;

    static final Vector3 CORNER000 = new Vector3();
    static final Vector3 CORNER010 = new Vector3();
    static final Vector3 CORNER100 = new Vector3();
    static final Vector3 CORNER110 = new Vector3();
    static final Vector3 CORNER001 = new Vector3();
    static final Vector3 CORNER011 = new Vector3();
    static final Vector3 CORNER101 = new Vector3();
    static final Vector3 CORNER111 = new Vector3();

    static final Vector3[] FACE0 = {CORNER000, CORNER100, CORNER110, CORNER010};
    static final Vector3[] FACE1 = {CORNER101, CORNER001, CORNER011, CORNER111};
    static final Vector3[] FACE2 = {CORNER000, CORNER010, CORNER011, CORNER001};
    static final Vector3[] FACE3 = {CORNER101, CORNER111, CORNER110, CORNER100};
    static final Vector3[] FACE4 = {CORNER101, CORNER100, CORNER000, CORNER001};
    static final Vector3[] FACE5 = {CORNER110, CORNER111, CORNER011, CORNER010};
    static final Vector3[][] FACES = {FACE0, FACE1, FACE2, FACE3, FACE4, FACE5};

    static final Vector3 NORMAL0 = new Vector3();
    static final Vector3 NORMAL1 = new Vector3();
    static final Vector3 NORMAL2 = new Vector3();
    static final Vector3 NORMAL3 = new Vector3();
    static final Vector3 NORMAL4 = new Vector3();
    static final Vector3 NORMAL5 = new Vector3();
    static final Vector3[] NORMALS = {NORMAL0, NORMAL1, NORMAL2, NORMAL3, NORMAL4, NORMAL5};

    public Cube(float x, float y, float z, float width, float height, float depth, int index, 
            VertexAttributes vertexAttributes, float[] meshVertices){
        position.set(x,y,z);
        this.halfWidth = width/2;
        this.halfHeight = height/2;
        this.halfDepth = depth/2;
        this.index = index;


        vertexFloatSize = vertexAttributes.vertexSize/4; //4 bytes per float
        posOffset = getVertexAttribute(Usage.Position, vertexAttributes).offset/4;
        norOffset = getVertexAttribute(Usage.Normal, vertexAttributes).offset/4;

        VertexAttribute colorAttribute = getVertexAttribute(Usage.Color, vertexAttributes);
        hasColor = colorAttribute!=null;
        if (hasColor){
            colOffset = colorAttribute.offset/4;
            this.setColor(Color.WHITE, meshVertices);
        }
        transformDirty = true;
    }

    public void setIndex(int index){
        this.index = index;
        transformDirty = true;
        colorDirty = true;
    }

    /**
     * Call this after moving and/or rotating.
     */
    public void update(float[] meshVertices){
        if (colorDirty && hasColor){
            for (int faceIndex= 0; faceIndex<6; faceIndex++){
                int baseVertexIndex = (index*24 + faceIndex*4)*vertexFloatSize;//24 unique vertices per cube, 4 unique vertices per face
                for (int cornerIndex=0; cornerIndex<4; cornerIndex++){
                    int vertexIndex = baseVertexIndex + cornerIndex*vertexFloatSize + colOffset;
                    meshVertices[vertexIndex] = color.r;
                    meshVertices[++vertexIndex] = color.g;
                    meshVertices[++vertexIndex] = color.b;
                    meshVertices[++vertexIndex] = color.a;
                }
            }
            colorDirty = false;
        }


        if (!transformDirty){
            return;
        }
        transformDirty = false;

        CORNER000.set(-halfWidth,-halfHeight,-halfDepth).rot(rotationTransform).add(position);
        CORNER010.set(-halfWidth,halfHeight,-halfDepth).rot(rotationTransform).add(position);
        CORNER100.set(halfWidth,-halfHeight,-halfDepth).rot(rotationTransform).add(position);
        CORNER110.set(halfWidth,halfHeight,-halfDepth).rot(rotationTransform).add(position);
        CORNER001.set(-halfWidth,-halfHeight,halfDepth).rot(rotationTransform).add(position);
        CORNER011.set(-halfWidth,halfHeight,halfDepth).rot(rotationTransform).add(position);
        CORNER101.set(halfWidth,-halfHeight,halfDepth).rot(rotationTransform).add(position);
        CORNER111.set(halfWidth,halfHeight,halfDepth).rot(rotationTransform).add(position);

        NORMAL0.set(0,0,-1).rot(rotationTransform);
        NORMAL1.set(0,0,1).rot(rotationTransform);
        NORMAL2.set(-1,0,0).rot(rotationTransform);
        NORMAL3.set(1,0,0).rot(rotationTransform);
        NORMAL4.set(0,-1,0).rot(rotationTransform);
        NORMAL5.set(0,1,0).rot(rotationTransform);

        for (int faceIndex= 0; faceIndex<6; faceIndex++){
            int baseVertexIndex = (index*24 + faceIndex*4)*vertexFloatSize;//24 unique vertices per cube, 4 unique vertices per face
            for (int cornerIndex=0; cornerIndex<4; cornerIndex++){
                int vertexIndex = baseVertexIndex + cornerIndex*vertexFloatSize + posOffset;
                meshVertices[vertexIndex] = FACES[faceIndex][cornerIndex].x;
                meshVertices[++vertexIndex] = FACES[faceIndex][cornerIndex].y;
                meshVertices[++vertexIndex] = FACES[faceIndex][cornerIndex].z;

                vertexIndex = baseVertexIndex + cornerIndex*vertexFloatSize + norOffset;
                meshVertices[vertexIndex] = NORMALS[faceIndex].x;
                meshVertices[++vertexIndex] = NORMALS[faceIndex].y;
                meshVertices[++vertexIndex] = NORMALS[faceIndex].z;
            }
        }
    }

    public Cube setColor(Color color){
        if (hasColor){
            this.color.set(color);
            colorDirty = true;
        }
        return this;
    }

    public Cube translate(float x, float y, float z){
        position.add(x,y,z);
        transformDirty = true;
        return this;
    }

    public Cube translateTo(float x, float y, float z){
        position.set(x,y,z);
        transformDirty = true;
        return this;
    }

    public Cube rotate(float axisX, float axisY, float axisZ, float degrees){
        rotationTransform.rotate(axisX, axisY, axisZ, degrees);
        transformDirty = true;
        return this;
    }

    public Cube rotateTo(float axisX, float axisY, float axisZ, float degrees){
        rotationTransform.idt();
        rotationTransform.rotate(axisX, axisY, axisZ, degrees);
        transformDirty = true;
        return this;
    }

    public VertexAttribute getVertexAttribute (int usage, VertexAttributes attributes) {
        int len = attributes.size();
        for (int i = 0; i < len; i++)
            if (attributes.get(i).usage == usage) return attributes.get(i);

        return null;
    }
}