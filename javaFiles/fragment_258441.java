JTextField[] searchField=new JTextField[10]
//... some code and functions 
for(int i =0; i <= 9; i++)
{
    nproductListModel.addElement(FindProducts.addProducts(searchField[i].getText()));
}