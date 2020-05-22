for (LLThoaiThang tt :listThoaiThang ) {
                int aa = tt.getThang() / 2+3;
                Cell x1 = row.getCell(aa);
                if(!tt.getNoiBo().isEmpty())
                    x1.setCellValue(Double.parseDouble(tt.getNoiBo())); //only this cell ok
                Cell x2 = row.getCell(aa+1);
                if(!tt.getNgoaiMang().isEmpty())
                    x2.setCellValue(Double.parseDouble(tt.getNgoaiMang()));;
}