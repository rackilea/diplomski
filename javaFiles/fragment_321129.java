if(VolumeInBTC < 0.5){
            PairFee = 0.0033; //0.33%
        }
        else if(VolumeInBTC >= 0.5 && VolumeInBTC < 1.0){
            PairFee = 0.0031; //0.31%
        }
        else if(VolumeInBTC >= 1.0 && VolumeInBTC < 5.0){
            PairFee = 0.0029; //0.29%
        }
        else if(VolumeInBTC >= 5 && VolumeInBTC < 20){
            PairFee = 0.0027; //0.27%
        }
        else if(VolumeInBTC >= 20){
            PairFee = 0.0025; //0.25%
        }
        else{
            System.exit(1);//something went wrong
        }
        return PairFee;
    }