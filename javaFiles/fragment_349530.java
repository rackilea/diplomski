StringBuilder sb = new StringBuilder( 128);

        sb.append("<html><table><tr>");

        for (int i = 0; i < informeMatrices.getVector().length; i++)
        {
            if (informeMatrices.getVector()[i] != null)
            {

                sb.append("<td>" + informeMatrices.getVector()[i] + "</td>");
            }
        }

        for (int i = 0; i < informeMatrices.getMatriz().length; i++) 
        {
            sb.append("<tr>");

            for(int u = 0; u < informeMatrices.getMatriz().length; u++)
            {
                if (informeMatrices.getMatriz()[i][u] != null)
                {                       
                    sb.append("<td>").append(informeMatrices.getMatriz()[i][u]).append("</td>");
                }

            }

            sb.append("</tr>");

        }

        sb.append("</table></html>");

        JOptionPane.showMessageDialog(null,sb.toString(),"Coleccion Completa",
                JOptionPane.INFORMATION_MESSAGE);