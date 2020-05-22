I had made decorators for it. We can't put image directly in the form inside display tag pagination.


deviceList.jsp

<display:table id="row" name="productEntities" pagesize="12" cellpadding="5px;" cellspacing="5px;" style="margin-left:50px;margin-top:20px;"   requestURI="" decorator="com.ei.openhome.utility.AddDeviceDecorator">>

<display:setProperty name="paging.banner.placement" value="bottom" />
<display:column value="<%=row_rowNum%>" title="Sr. No" />  
<display:column property="prodName" title="Product Name"/>
<display:column property="modelName" title="Model"/>
<display:column property="manufacturer.mfgName" title="Manfufacturer name"/>
<display:column property="category.catName" title="Category"/>
<display:column property="active" title="Active"/>
<display:column property="image_2" title="Edit" />
<display:column property="image_1" title="Delete" />

</display:table>

AddDeviceDecorator.java

public class AddDeviceDecorator extends TableDecorator {



    public String getImage_1()
    {
        ProductEntity actorData = (ProductEntity)getCurrentRowObject();

        String onclick = "onclick=deletes("+actorData.getId()+");";
         String image_1 =  "<img src="+"\""+"/openhome/images/system/delete.png"+"\""+" "+onclick+">";
        return image_1;
    }

    public String getImage_2()
    {
        ProductEntity actorData = (ProductEntity)getCurrentRowObject();


        String onclick = "onclick=edit("+actorData.getId()+");";
         String image_2 =  "<img src="+"\""+"/openhome/images/system/edit.png"+"\""+" "+onclick+">";
        return image_2;
    }

}