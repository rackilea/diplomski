try{

          Document document = null;
          Element root = null;
          File xmlFile = new File("generatedXmlFiles/listeCompte.xml");

        if(xmlFile.exists()){

              FileInputStream fis = new FileInputStream(xmlFile);
              SAXBuilder sb = new SAXBuilder();
              document = sb.build(fis);
              root = document.getRootElement();
              fis.close();
          }else{
              document = new Document();
              root = new Element("banque");
          }

          Element compte = new Element("compte");
          compte.setAttribute(new Attribute("idCompte", this.idCompte));
          compte.addContent(new Element("numCompte").setText(this.idCompte));
          compte.addContent(new Element("nom").setText(this.nom));
          compte.addContent(new Element("solde").setText(this.solde));

          root.addContent(compte);
          document.setContent(root);

          FileWriter writer = new FileWriter("generatedXmlFiles/listeCompte.xml");
            XMLOutputter outputter = new XMLOutputter();
            outputter.setFormat(Format.getPrettyFormat());
            outputter.output(document, writer);
            outputter.output(document, System.out);
            writer.close(); // close writer

          } catch (IOException io) {
            System.out.println(io.getMessage());
          } catch (JDOMException e) {
            e.printStackTrace();
        }