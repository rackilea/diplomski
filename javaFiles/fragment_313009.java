Iterator<CElem> oItr = linkedList.iterator();
    {
        while (oItr.hasNext())
        {
            CElem outer = oItr.next();              
            Iterator<CElem> iItr = linkedList.iterator();
            {
                while (iItr.hasNext())
                {
                    CElem inner = iItr.next();
                    if (outer.equals(inner))
                        continue;

                    if (outer.getKey().equals(inner.getKey()))
                    {
                        inner.getValues().addAll(outer.getValues());
                        outer.remove();
                        break;
                    }
                }
            }
        }
    }