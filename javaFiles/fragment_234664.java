#pragma DCPS_DATA_TYPE "B::CData"

module B { 

   typedef struct Quote {
        string skit_name;
        string episode_name;     
        string line;
    }QuoteData;

    struct CData{
        long id;
        QuoteData payload;
    };
};