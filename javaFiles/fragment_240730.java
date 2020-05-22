//we need this class to allow flooring just by id
 public class IntegerPersonAdapter extends Person {
    private Integer id;
    public IntegerPersonAdapter(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        return id.equals(o);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        return id.hashCode() - o.hashCode();
    }

    @Override
    public String toString() {
        return id.toString();
    }
}

public class StrictCountryTreeSet extends TreeSet<Person> {

    @Override
    public Person floor(Person e) {
        Person candidate = super.floor(e);
        if (candidate != null) {
            //we check if the country is the same
            int candidateCode = candidate.hashCode();
            int eCode = e.hashCode();
            if (candidateCode == eCode) {
                return candidate;
            } else {
                int countryCandidate = candidateCode / 10000000;
                if (countryCandidate == (eCode / 10000000)) {
                    //we check if the state is the same
                    int stateCandidate = candidateCode / 10000;
                    if (stateCandidate == (eCode / 10000)) {
                        //we check if is a state
                        if (candidateCode % 10 == 0) {
                            return candidate;
                        } else { //since it's not exact match we haven't found a city - we need to get someone just from state
                            return this.floor(new IntegerPersonAdapter(stateCandidate * 10000));
                        }

                    } else if (stateCandidate % 10 == 0) { //we check if it's a country already
                        return candidate;
                    } else {
                        return this.floor(new IntegerPersonAdapter(countryCandidate * 10000000));
                    }
                }
            }
        }
        return null;
    }