use Inline (
    Java => 'DATA',
    J2SDK => $ENV{JAVA_HOME},
    CLASSPATH => $PERL_CLASSPATH,
    STUDY => ["SFTP", "close", "list", "get", "put", "remove"],
#    DEBUG => 4,
);