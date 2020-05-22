package jcc.tj.dnamatch;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gene {
   private String gene;

   public Gene() {}

   public Gene( String gene ) {
      this.gene = gene;
   }

   public List<Integer> find( String seq ) {
      List<Integer> indices = new ArrayList<Integer>();

      Pattern pat = Pattern.compile( seq );
      Matcher m = pat.matcher( gene );

      while ( m.find() )
         indices.add( m.start() );

      return indices;
   }

   public String getGene() {
      return gene;
   }

   public void setGene( String gene ) {
      this.gene = gene;
   }
}