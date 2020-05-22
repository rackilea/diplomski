import geq.gdig.dao.ConexionBD;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.XmlOptions;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;

/**
 *
 * @author euriber
 */
public class PruebaBLOB extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * 
     * @param request
     *            servlet request
     * @param response
     *            servlet response
     * @throws ServletException
     *             if a servlet-specific error occurs
     * @throws IOException
     *             if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // PrintWriter out = response.getWriter();
        System.out.println("Hola");
        String lNombreArchivo = null;
        // An ordered list
        List<Blob> blobContent = new LinkedList<Blob>();
        // query content from documentos_blob for multiple document ids and
        // return all content in a single result set
        String query1 = "select d.id_documento,(select bl.content from documentos_blob bl where bl.id_documento=69)content69,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=63)content63,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=53)content53,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=68)content68,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=54)content54,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=55)content55,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=74)content74,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=51)content51,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=75)content75,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=60)content60,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=56)content56,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=61)content61,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=59)content59,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=57)content57,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=62)content62,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=52)content52,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=73)content73,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=58)content58,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=65)content65,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=64)content64,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=66)content66,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=67)content67,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=70)content70,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=71)content71,"
                + "(select bl.content from documentos_blob bl where bl.id_documento=72)content72"
                + " from documentos d where d.id_documento = 1";

        String query2 = "select d.* from documentos d where d.id_documento= 2";
        Context ic = null;
        DataSource dataSource = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            System.out.print("Dentro del try");
            ic = new InitialContext();
            dataSource = (DataSource) ic.lookup(ConexionBD.DATA_SOURCE_GEQGDIG);
            conn = dataSource.getConnection();
            st = conn.createStatement();
            System.out.print("Antes de execute...");
            rs = st.executeQuery(query1);
            System.out.print(query1);
            System.out.print("Después de execute...");

            // Iterate over the result set (one iteration only??)
            while (rs.next()) {
                // System.out.print("Dentro del while...");
                lNombreArchivo = "PED_SPF_1ER_INFORME.docx";
                System.out.println("lNombreArchivo-->" + lNombreArchivo);
                // Get blob data from each column in the result set

                blobContent.add(rs.getBlob("CONTENT69"));
                blobContent.add(rs.getBlob("CONTENT63"));
                blobContent.add(rs.getBlob("CONTENT53"));
                blobContent.add(rs.getBlob("CONTENT68"));
                blobContent.add(rs.getBlob("CONTENT54"));
                blobContent.add(rs.getBlob("CONTENT55"));
                blobContent.add(rs.getBlob("CONTENT74"));
                blobContent.add(rs.getBlob("CONTENT51"));
                blobContent.add(rs.getBlob("CONTENT75"));
                blobContent.add(rs.getBlob("CONTENT60"));
                blobContent.add(rs.getBlob("CONTENT56"));
                blobContent.add(rs.getBlob("CONTENT61"));
                blobContent.add(rs.getBlob("CONTENT59"));
                blobContent.add(rs.getBlob("CONTENT57"));
                blobContent.add(rs.getBlob("CONTENT62"));
                blobContent.add(rs.getBlob("CONTENT52"));
                blobContent.add(rs.getBlob("CONTENT73"));
                blobContent.add(rs.getBlob("CONTENT58"));
                blobContent.add(rs.getBlob("CONTENT65"));
                blobContent.add(rs.getBlob("CONTENT64"));
                blobContent.add(rs.getBlob("CONTENT66"));
                blobContent.add(rs.getBlob("CONTENT67"));
                blobContent.add(rs.getBlob("CONTENT70"));
                blobContent.add(rs.getBlob("CONTENT71"));
                blobContent.add(rs.getBlob("CONTENT72"));

                // prepare response headers
                response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document"
                        + "; name=\"" + lNombreArchivo + "\"");
                response.setHeader("Content-disposition", "attachment; filename=\"" + lNombreArchivo + "\"");
                // prepare output stream
                OutputStream os = response.getOutputStream();
                // Bind OPCPackages to each inputstream
                CTBody src = null;
                XWPFDocument outDoc = null;
                StringBuilder sb = new StringBuilder();
                Iterator<Blob> li = blobContent.listIterator();
                String suffix;
                XmlOptions optionsOuter = new XmlOptions();
                optionsOuter.setSaveOuter();
                while (li.hasNext()) {
                    // for each blob
                    Blob b = li.next();
                    // Do the repeated stuff
                    InputStream is = b.getBinaryStream();
                    OPCPackage opc = OPCPackage.open(is);
                    XWPFDocument doc = new XWPFDocument(opc);
                    CTBody body = doc.getDocument().getBody();
                    if (sb.length() == 0) {
                        // First blob in the list we only enter here
                        outDoc = doc;
                        // Get src XML text string
                        String bodyXml = body.xmlText();
                        // Get prefix xml tag
                        sb.append(bodyXml.substring(0, bodyXml.indexOf(">") + 1));
                        // Get main XML body
                        sb.append(bodyXml.substring(bodyXml.indexOf(">") + 1, bodyXml.lastIndexOf("<")));
                        // Get final XML tag
                        suffix = bodyXml.substring(bodyXml.lastIndexOf("<"));
                    } else {
                        // all other blobs in the list, get the body XML between
                        // first and last XML tags
                        String bodyXml = body.xmlText(optionsOuter);
                        sb.append(bodyXml.substring(bodyXml.indexOf(">") + 1, bodyXml.lastIndexOf("<")));
                    }
                }
                // Finally append the suffix
                sb.append(suffix);
                // Rewrite the document body with the entire contents of the
                // string builder.
                outDoc.getDocument().getBody().set(CTBody.Factory.parse(sb.toString()));
                // Write it out to the stream
                outDoc.write(os);
                // OutputStream os
                os.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (Exception e) {
            }
        }
    }

}