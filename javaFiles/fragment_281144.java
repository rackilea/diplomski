public static string getTableData(Document doc){
    StringBuilder sb = new StringBuilder();
    for(Element table : doc.select("tbody")){       
         int i = 0;
         for (Element row : table.select("tr")) {
            i++;
            for (Element sale1 : row.select("td.sale_type.bottomline div.inner.pl4")){
                 sb.Append(i + " : " + sale1.text() + " / ");
            }
            for (Element sale2 : row.select("td.sale_type2.bottomline div.inner")){
                 sb.Append(sale2.text() + " / ");
            }
            for (Element date : row.select("td.bottomline div.inner.inner_mark span.mark4")){
                 sb.Append(date.text() + " / ");
            }
            for (Element add : row.select("td.align_l.name div.inner ")){
                 sb.Append(add.text() + " / ");
            }
            for (Element size : row.select("td.num div.inner ")){
                 sb.Append(size.text() + " / ");                 
            }
            for (Element floor : row.select("td.num2 div.inner ")){
                 sb.Append(floor.text()+ " / ");                 
            }
            for (Element price : row.select("td.num.align_r div.inner ")){
                 sb.Append(price.text()+ " / ");                 
            }
            for (Element cont : row.select("td.contact.bottomline div.inner ")){
                 sb.Append(cont.text());                   
            }
         }
    }
    return sb.toString();
}