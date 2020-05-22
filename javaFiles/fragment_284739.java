currentQ = quesList.get(qid);
        List<FirstFragment> fragments =new Vector<FirstFragment>();
        fragments.add(FirstFragment.newInstance(0,currentQ.getQUESTION(),currentQ.getOPTA(),currentQ.getOPTB(),currentQ.getOPTC()));
        qid++;
currentQ = quesList.get(qid);
        fragments.add(FirstFragment.newInstance(1,currentQ.getQUESTION(),currentQ.getOPTA(),currentQ.getOPTB(),currentQ.getOPTC()));
        qid++;
currentQ = quesList.get(qid);
        fragments.add(FirstFragment.newInstance(2,currentQ.getQUESTION(),currentQ.getOPTA(),currentQ.getOPTB(),currentQ.getOPTC()));