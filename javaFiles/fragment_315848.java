while(results.next())
{
   Vector<Objetc> element = new Vector<Object>

   for(counter=0;counter<ColumnNamesCollections.size();counter++)
   {

      element.add(results.getObjetc(counter))
   }

   model.addRow(element);
}