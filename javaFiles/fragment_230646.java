public void onselectSuc() {     

      if(sucursal==null){
        sucursal = " - ";
      }  

      String[] vecsuc = sucursal.split("\\ - ", -1);


      HttpServletRequest rq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
      String ntrabajador = rq.getParameter("formshametas:numtrabajadores");
        //Consulta que hace la seleccion automatica para los inputtext de los empelados, valores nombre completo, genero, cargo!!!

      System.out.println("numtrabajadores: " + ntrabajador);

      //System.out.println("anio: " + anio);
      //System.out.println("mes: " + mes);
     String query = " SELECT COUNT(A.FICTRA) AS HEADCOUNT, CASE WHEN COUNT(A.FICTRA) = 0 THEN 0 WHEN COUNT(A.FICTRA) IS NULL THEN 0 ELSE TRUNC(" + ntrabajador + "/COUNT(A.FICTRA),2) END AS PROMEDIO";
            query += " FROM NM_TRABAJADOR@INFOCENT_CALENDARIO A";
            query += " WHERE A.CODSUC like '" + vecsuc[0].toUpperCase() + "%'";
            query += " AND A.FECRET IS NULL ";
            query += " ORDER BY 1";

         PntGenerica select = new PntGenerica();
           try {
            select.selectPntGenerica(query,JNDIDESA);
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           int rows = select.getRows();
           String vltabla[][] = select.getArray();
           if(rows>0){
             zuno = vltabla[0][0];
             zdos = vltabla[0][1];
             //ztres = vltabla[0][2];
           }
           System.out.println(query);
           //System.out.println("zuno:" + zuno);
           //System.out.println("zuno:" + zdos);
           //System.out.println("zuno:" + ztres);
    }