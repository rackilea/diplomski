String str = "\"hhhead\":\"Melvin\",\"respondent\":\"Edlen\",\"int_date\":\"2017-06-1\u200C\u200B5\",\"start_time\":\"09:\u200C\u200B46\",\"interviewer\":\"K\u200C\u200Bit\",\"house_type\":\"1\"\u200C\u200B,\"nbr\":2,\"nstorey\":1\u200C\u200B,\"roof\":\"1\",\"wall\":\"\u200C\u200B2\",\"floor\":\"7\",\"nnuc\u200C\u200Bfam\":1,\"phsize\":5,\"h\u200C\u200Bpq_mem\":[{\"memno\":\"1\u200C\u200B\",\"msname\":\"Malabarb\u200C\u200Bas\",\"mfname\":\"Melvin\u200C\u200B\",\"mmname\":\"Pirneto\"\u200C\u200B,\"reln\":\"1\",\"reln_o\"\u200C\u200B:\"\",\"nucfam\":\"1\",\"se\u200C\u200Bx\":\"1\",\"birth_date\":\u200C\u200B\"1969-12-18\"";
        Map<String,String> map = new HashMap<String,String>();
        String[] split = str.split(",");
        for(String s: split){
            String[] split2 = s.split(":");
            map.put(split2[0], split2[1]);
        }

        System.out.println(map.get("\"hhhead\""));