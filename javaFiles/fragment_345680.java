boolean containsMedia = false;

for ( File file : filesInWordFolder ) {

if ( file.getName().contains("media") ){
 containsMedia = true;
break;
}

// now check your boolean
if ( !containsMedia ) {