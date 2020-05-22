int i = 1;
            for (Element element : kids)
            {
                if(i == index)
                {
                    element.detach();
                    break;
                }
                else
                {
                i = i + 1;
                }               
            }