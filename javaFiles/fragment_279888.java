public interface CarFactory {
   Car create (String brand, String model);
}


@Bean
public CarFactory carFactory () {
   return CarImpl::new;
}