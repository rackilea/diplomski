public class BookData  implements Serializable {

    private String ISBN;
    private String titre;
    private String auteur;
    private int ID;
    private String editeur;

//ADD GETTER AN SETTER METHODS 



public BookData(String titre, String auteur, int ID, String editeur,String ISBN) {

        this.titre = titre;
        this.auteur = auteur;
        this.ID = ID;
        this.editeur = editeur;
        this.ISBN = ISBN;
    }


public List<BookData> loadData(String book )
    {
        List<BookData> actorList = new ArrayList<BookData>();

        com.mysql.jdbc.PreparedStatement ps = null;  




            ResultSet rs = null;  

             String url="jdbc:mysql://127.0.0.1:3306/DATABASENAME";//CHANGE
            String name="NAME";//CHANGE
            String pw="PWD";//CHANGE
            String driver="com.mysql.jdbc.Driver";    


            Connection connexion=null;


try
{    
    Class.forName(driver).newInstance();
    connexion=DriverManager.getConnection(url,name,pw);        


              String q = "Select * from book where Book_Name ='"+book+"'";
           Statement commande=connexion.createStatement();
              rs=commande.executeQuery(q);                 
               while (rs.next())
                {

BookData bk = new BookData(rs.getString("Book_Title"),rs.getString("Book_Author"),rs.getInt("ID"),rs.getString("Publisher"),rs.getString("ISBN"));/*CHANGE COLUMN NAMES*/

                actorList.add(bk);

                }


                return actorList;


                }catch(Exception e)
                {
                e.printStackTrace();

                return null;

                }
                finally
                {
                try
                {
                rs.close();
                connexion.close();

                }
                catch(Exception e)
                {
                e.printStackTrace();
                }
                }

    }

}