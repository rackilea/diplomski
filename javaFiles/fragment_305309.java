public interface ShippingProviderOption {
}

public enum UPSOption implements ShippingProviderOption {
    ...
}

public enum FedexOption implements ShippingProviderOption {
    ...
}

public interface ShippingProvider {

   public ShippingResponse ship(ShippingProviderOption option);
}

public class UPSProvider implements ShippingProvider {

   @Override
   public ShippingResponse ship(ShippingProviderOption option) {

       if(option == UPSOption.PackageType) {
          ...
       }
   }       
}

public class FedexProvider implements ShippingProvider {

   @Override
   public ShippingResponse ship(ShippingProviderOption option) {

       if(option == FedexOption.PickupType) {
          ...
       }
   }       
}