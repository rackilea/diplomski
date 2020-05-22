while (passb<8){
            bekaxd = generator.nextInt(11);
            gracz[licznik] = bekaxd;
            System.out.println("licznik:" + licznik + "gracz: " + gracz[licznik] + "pula" + Pula[gracz[licznik]]);
            if (Pula[gracz[licznik]]>0) {
                Pula[gracz[licznik]]--;
                passb = 15;
            }

        }


        }
      licznik++;