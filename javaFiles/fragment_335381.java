@Override
    public void setValueAt(Object inValue, int inRow, int inCol) {
        if(inRow < 0 || inCol < 0 || inRow >= getRowCount() )
            return;

        WrapperKitchen jelo= hrana.get(inRow);
            switch (inCol) {
                case 0:jelo.setIdUslugaHrana((properCast)inValue);break;
                case 1:jelo.setBrojSobe((properCast)inValue);break;
                case 2:jelo.setNazivKategorija((properCast)inValue);break;
                case 3:jelo.setNazivHrane((properCast)inValue);break;
                case 4:jelo.setKolicina((properCast)inValue);break;
                case 5:jelo.setNapomena((properCast)inValue);break;
                case 6:jelo.setDatumVrijeme((properCast)inValue);break;
                case 7:jelo.setIzvrseno((properCast)inValue);break;
                default: throw new RuntimeException("something bad happen incorrect column " + inCol);
            }

        }
        fireTableCellUpdated(inRow, inCol);


    }