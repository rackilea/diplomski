ENGINE HeidelTime;
TYPESYSTEM HeidelTime_TypeSystem;
ANY{-> Token};// mock tokenizer and sentence splitter
(# PERIOD){-> Sentence};
(PERIOD # PERIOD){-> Sentence};
EXEC(HeidelTime, {Timex3});
t:Timex3{t.timexType == "DATE"}; // do something with a date