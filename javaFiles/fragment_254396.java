for( Iterator<Realtorio> iter = realtorios.iterator( ); iter.hasNext( ); )
{
   Relatorio cur = iter.next( );

   if(!contem(cur)){
      iter.remove( );
   }
}