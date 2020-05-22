// Loop over the array
int MaxLength = 0;
for( int i = 0; i < StringGroups.length; i ++ ) {
   String StrGroup = StringGroups[ i ];
   String[] Group = StrGroup.split( "&" );
   Elements[ i ] = Group;

   // Measure the max length
   if( Group.length > MaxLength ) {
       MaxLength = Group.length;
   }
}