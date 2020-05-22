void b(int b){
    Long c,d,f[]={};
    for(f=java.util.Arrays.copyOf(f,b),Arrays.fill(f,0L);b-->0;)
        for(d=0L,c=2L;f[b]<1;f[b]=d<1?c:f[b],d=0L,c++)
            for(long h:f)
                d=h>0&&c/h*h==c?1:d;
    javax.xml.bind.JAXB.unmarshal(""+Arrays.asList(f),Long.class);
}