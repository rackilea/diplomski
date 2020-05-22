public String generierenummern() { // 4 numbers are generated and returned as total
teilnummern1 = nummern[(int) (Math.random() * 9 + 1)] + "";
teilnummern2 = nummern[(int) (Math.random() * 9 + 1)] + "";
teilnummern3 = nummern[(int) (Math.random() * 9 + 1)] + "";
teilnummern4 = nummern[(int) (Math.random() * 9 + 1)] + "";
return(teilnummern = teilnummern1 + teilnummern2 + teilnummern3 + teilnummern4 + "");