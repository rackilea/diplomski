// Create Channel Power Buckets
        for(; channel <= channel_end; channel+=increment ){ 
            //Initial Bucket
            while((start_frequency >= channel) && (start_frequency < (channel + increment))){
                list.add(new Value(channel, power));
                channel+=increment;
            }
            //Buckets to Accomodate for Bandwidth
            while ((channel <= channel_end) && (channel >= start_frequency) && (start_frequency + bandwidth) >= channel){
                list.add(new Value(channel, power));                           
                channel+=increment;
            }                   
        }