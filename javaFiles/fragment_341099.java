for(int xx=0;xx<temp.length;xx++)
    {
     rule=temp[xx][1]; 
     cons=temp[xx][2];
     boolean setXXtoZero = fp.factprocess(fact, rule, vars, cons);
     if(setXXtoZero) xx=-1;

    }