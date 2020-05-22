@Node(jcrMixinTypes="mix:lockable" )
public class A
{
@Field(path=true) private String path;
@Field private String a1;
@Field private String a2;
@Bean(jcrType="nt:unstructured", jcrOnParentVersion="IGNORE") private B b;