int main(int argc, char *argv[]) {
        NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
        NSDictionary *appDefaults = [NSDictionary dictionaryWithObject:@"NO" 
            forKey:@"AppleMomentumScrollSupported"];
        [defaults registerDefaults:appDefaults];

        // ...
    }