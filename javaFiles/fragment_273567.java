@Deprecated
public class AdoptDog extends AdoptPet {
    @Deprecated
    public interface OnDogAdoption {
        @Deprecated
        public void onDogAdoption(String dogName);
    }

    private static class DogAdoptionDispatcher implements AdoptPet.OnPetAdoption {
            final OnDogAdoption target;
            public DogAdoptionDispatcher(OnDogAdoption target) {
                this.target = target;
            }
            @Override
            public void onPetAdoption(String petName) {
                target.onDogAdoption(petName);
            }
    }

    @Deprecated
    public void adoptDog(final String dogName, OnDogAdoption callbackObj) {
        super.adoptPet(dogName, new DogAdoptionDispatcher(callbackObj));
    }
}