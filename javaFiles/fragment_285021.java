class HeaderList
        {

            private String h1;

            private String h2;

            private String h3;

            public HeaderList(String h1, String h2, String h3)
            {
                super();
                this.h1 = h1;
                this.h2 = h2;
                this.h3 = h3;
            }

            /**
             * The hash code method which generate same hashkey for h1 and h2.
             * 
             * @inheritDoc
             */
            @Override
            public int hashCode()
            {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((h1 == null) ? 0 : h1.hashCode());
                result = prime * result + ((h2 == null) ? 0 : h2.hashCode());
                return result;
            }

            /**
             * The equals method assumes each csv file row will be uniquely identified my h1 and h2
             * combined. Please see if h1 and h2 cannot be uniquely identified then it may lead to data
             * loss. For h3 we return true only for same values.
             * 
             * @inheritDoc
             */
            @Override
            public boolean equals(Object obj)
            {
                if (this == obj)
                    return true;
                if (obj == null)
                    return false;
                if (getClass() != obj.getClass())
                    return false;
                HeaderList other = (HeaderList) obj;
                if (h1 == null)
                {
                    if (other.h1 != null)
                        return false;
                }
                else if (!h1.equals(other.h1))
                    return false;
                if (h2 == null)
                {
                    if (other.h2 != null)
                        return false;
                }
                else if (!h2.equals(other.h2))
                    return false;
                if (h3 == null)
                {
                    if (other.h3 == null)
                        return false;
                }
                else if (h3.equals(other.h3))
                    return false;
                return true;
            }

            /**
             * @inheritDoc
             */
            @Override
            public String toString()
            {
                return "HeaderList [h1=" + h1 + ", h2=" + h2 + ", h3=" + h3 + "]";
            }

        }