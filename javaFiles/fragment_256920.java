import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.ColumnBuilder;
import ar.com.fdvs.dj.domain.builders.DynamicReportBuilder;
import ar.com.fdvs.dj.domain.constants.Border;
import ar.com.fdvs.dj.domain.constants.Font;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.constants.Page;
import ar.com.fdvs.dj.domain.constants.Transparency;
import ar.com.fdvs.dj.domain.constants.VerticalAlign;
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn;

HttpServletResponse response = getContext().getResponse();

            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setCharacterEncoding("ISO-8859-1");

            response.setContentType("application/pdf");     
            response.setHeader("Content-Disposition", "attachment; filename=example.pdf");


DynamicReportBuilder drb = new DynamicReportBuilder();

                Style detailStyle = new Style();
                detailStyle.setBorderTop(Border.THIN);
                detailStyle.setBorderBottom(Border.THIN);
                detailStyle.setBorderLeft(Border.THIN);
                detailStyle.setBorderRight(Border.THIN);

                Style headerStyle = new Style();
                headerStyle.setFont(Font.ARIAL_MEDIUM_BOLD);
                headerStyle.setBorderBottom(Border.THIN);
                headerStyle.setBackgroundColor(Color.gray);
                headerStyle.setTextColor(Color.white);
                headerStyle.setHorizontalAlign(HorizontalAlign.CENTER);
                headerStyle.setVerticalAlign(VerticalAlign.MIDDLE);
                headerStyle.setTransparency(Transparency.OPAQUE);

                Style headerVariables = new Style();
                headerVariables.setFont(Font.ARIAL_MEDIUM_BOLD);
                headerVariables.setHorizontalAlign(HorizontalAlign.RIGHT);
                headerVariables.setVerticalAlign(VerticalAlign.MIDDLE);

                Style titleStyle = new Style();
                titleStyle.setFont(new Font(18, Font._FONT_VERDANA, true));

                Style importeStyle = new Style();
                importeStyle.setHorizontalAlign(HorizontalAlign.RIGHT);
                Style oddRowStyle = new Style();
                oddRowStyle.setBorder(Border.NO_BORDER);
                oddRowStyle.setBackgroundColor(Color.LIGHT_GRAY);
                oddRowStyle.setTransparency(Transparency.OPAQUE);

                drb.addTitle(sessao.getNomeCliente());              
                drb.addTitleStyle(titleStyle);

                drb.addSubtitle("Consulta O.S.");

                drb.addOddRowBackgroundStyle(oddRowStyle);
                drb.addDefaultStyles(titleStyle, null, headerStyle, detailStyle);

                drb.addPageSizeAndOrientation(Page.Page_A4_Landscape());

                int top = 10;
                int bottom = 10;
                int left = 10;
                int right = 10;
drb.addMarginss(top, bottom, left, right);  


if (searchResults.isThereThisField()) {

                    AbstractColumn columnState = ColumnBuilder.getInstance()
                    .addColumnProperty("numeroOs", Integer.class.getName())         
                    .addTitle("This Field")             
                    .addWidth(5)
                    .build();   

                    drb.addColumn(columnState);

                }