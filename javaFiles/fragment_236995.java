use Inline (
    Java => 'DATA',
    J2SDK => $ENV{JAVA_HOME},
    CLASSPATH => $PERL_CLASSPATH,
    STUDY => ["SFTP"],
#    DEBUG => 4,
);