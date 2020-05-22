ResultSet srs = st.executeQuery("SELECT * FROM subsections inner join sections on         subsections.id_section=sections.id_section");

//variables for current and previous section ids (initially 0 = non-existent)
int idCurrentSection = 0;
int idPreviousSection = 0;

while (srs.next()) {
    idCurrentSection = srs.getInt("id_section"); //get and save the current section id
//if previous section is equal to current section we skip closing and opening a new     section block and just write the subsection name
    if(idCurrentSection!=idPreviousSection){ //if current section is different from previous section we need to start a new section block
        if(idPreviousSection != 0) //if previous section id is different from 0 we need to close the previous section block
            System.out.println("</div>");
        System.out.println("<div class='section'>"); //open a new section block
    }


    System.out.println("<p>"+srs.getInt("section_name")+"</p>");    //write the new section name

    System.out.println("<div class='subsection'>"); //start a new subsection
    System.out.println("<p>"+srs.getInt("subsection_name")+"</p>"); //write the subsection name
    System.out.println("</div>"); //inchid subsectiunea

    idPreviousSection = idCurrentSection; //previous section is now the current section

   }

System.out.println("</div>"); //careful to close the last section block