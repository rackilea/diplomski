private String child_id;
        private String address;

        public String getAddress() {
            return address;
        }




        public void setAddress(String address) {
            this.address = address;
        }

        final public HashMap<String,ArrayList<String>> childVaccineListByDate=new  HashMap<String,ArrayList<String>>();


        public void addVaccine(String date, String vaccineName)
        {
            ArrayList<String> listOfVaccineNames;

            if(childVaccineListByDate.containsKey(date) )
            {
                listOfVaccineNames=childVaccineListByDate.get(date);
                if(!listOfVaccineNames.contains(vaccineName))
                {
                    listOfVaccineNames.add(vaccineName);
                }

            }else
            {
                listOfVaccineNames=new ArrayList<String>();
                listOfVaccineNames.add(vaccineName);
                childVaccineListByDate.put(date,listOfVaccineNames);
            }

        }




        public HashMap<String, ArrayList<String>> getChildVaccineListByDate() {
            return childVaccineListByDate;
        }




        public String getChild_id() {
            return child_id;
        }

        public void setChild_id(String child_id) {
            this.child_id = child_id;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result
                    + ((child_id == null) ? 0 : child_id.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            ChildVaccine other = (ChildVaccine) obj;
            if (child_id == null) {
                if (other.child_id != null)
                    return false;
            } else if (!child_id.equals(other.child_id))
                return false;
            return true;
        }