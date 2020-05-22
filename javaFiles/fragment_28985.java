public Card newCard(){
        Card take=null;
            for(int i = 0; i < CardsR.length; i++){
                if(CardsR[i]!=null){
                    take=Cards[i];
                    CardsR[i]=null;
                    break;
                }
            }
        }
        return take;
    }