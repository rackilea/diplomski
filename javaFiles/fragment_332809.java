public static void main(String[] args) throws VTDException,IOException,
    UnsupportedEncodingException{
        String charsetName = "UTF-16";
        byte[] root = "<ROOT><a><b/></a><a><b/></a><a><b/></a><a><b/></a></ROOT>"
    .getBytes(charsetName); // that is template you want to start with
        VTDGen vg = new VTDGen();
        AutoPilot ap = new AutoPilot();
        ap.selectXPath("/ROOT/a/b");
        XMLModifier xm = new XMLModifier();
        vg.setDoc(root);
        vg.parse(false);
        VTDNav vn = vg.getNav();
        ap.bind(vn);
        xm.bind(vn);
        int i=0;
        int[] ia = new int[4];
        ia[0]=1;ia[1]=1;ia[2]=2;ia[3]=2;
        String[] sa = new String[4];
        sa[0]="a";sa[1]="b";sa[2]="a";sa[3]="b";
        int k=0;
        while((i=ap.evalXPath())!=-1){
            xm.insertAttribute( String.format(" attr1=\"%d\" attr2=\"%s\"",
                    ia[k],
                    sa[k]));
            k++;
        }
        XMLByteOutputStream xbos = new XMLByteOutputStream(xm.getUpdatedDocumentSize());
        xm.output(xbos);
        System.out.println(new String(xbos.getXML(),"UTF-16"));
    }