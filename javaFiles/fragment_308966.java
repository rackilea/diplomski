Git = createObject( 'java', 'org.eclipse.jgit.api.Git' );

localPath = createObject( 'java', 'java.io.File' ).init( expandPath( 'temp' ) );

result = Git.cloneRepository()
        .setURI( 'https://github.com/github/testrepo.git' )
        .setDirectory( localPath )
        .call();

result.getRepository().close();
result.close();