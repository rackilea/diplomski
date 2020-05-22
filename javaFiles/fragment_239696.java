public class Texture {

    private int textureObject;
    private int width;
    private int heigth;

    public Texture (String filename) {

        IntBuffer width = BufferUtils.createIntBuffer(1);
        IntBuffer heigth = BufferUtils.createIntBuffer(1);
        IntBuffer comp = BufferUtils.createIntBuffer(1);

        ByteBuffer data = stbi_load("./res/" + filename, width, heigth, comp, 4);

        this.width = width.get();
        this.heigth = heigth.get();

        textureObject = glGenTextures(); // generate texture name
        glBindTexture(GL_TEXTURE_2D, textureObject);

        glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, this.width, this.heigth, 0, GL_RGBA, GL_UNSIGNED_BYTE, data);   

        stbi_image_free(data);

    }

    public void bind (int sampler) {

        if (sampler >= 0 && sampler <= 31) {

            glActiveTexture(GL_TEXTURE0 + sampler);
            glBindTexture(GL_TEXTURE_2D, textureObject); // bind texture object 
        }
    }
}