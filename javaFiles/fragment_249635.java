public class DTOConstantElementVisitor extends AbstractElementVisitor6<Void, String> {

    private static final String FIELD_PREFIX = "public static final String ";

    private String fileName = null;

    private String clazzName;
    private String pkg;

    private StringBuffer fileContentBuff;

    @Override
    public Void visitPackage( PackageElement e, String p ) {
        System.out.println( "visitPackage" + e );

        return null;
    }

    @Override
    public Void visitType( TypeElement e, String p ) {
        System.out.println( "visitTypeElement" + e );

        try {
            Class<?> clazz = Class.forName( e.getQualifiedName().toString() );
            this.clazzName = clazz.getSimpleName();
            createFileName( clazz );

            this.pkg = clazz.getPackage().getName();
            this.fileContentBuff = new StringBuffer();

            fileContentBuff.append( "package " + this.pkg + ";\n" );
            fileContentBuff.append( "public aspect " + this.fileName + " {\n" );

            for( Field field : clazz.getDeclaredFields() ) {
                if( Modifier.isPrivate( field.getModifiers() ) ) {
                    String fieldName = field.getName();

                    if( shouldGenerateField( fieldName ) ) {
                        fileContentBuff.append( FIELD_PREFIX + clazzName + "."
                                + fieldName.toUpperCase() + " = \"" + fieldName + "\";\n" );
                    }

                }
            }
            fileContentBuff.append( "}\n" );

            System.out.println( fileContentBuff.toString() );

        }
        catch( ClassNotFoundException e1 ) {
            throw new java.lang.RuntimeException( e1 );
        }

        return null;
    }
    private boolean shouldGenerateField( String fieldName ) {
        if( "serialVersionUID".equals( fieldName ) ) {
            return false;
        }
        return true;
    }

    private void createFileName( Class clazz ) {
        this.fileName = clazzName + "Aspect";
    }
}