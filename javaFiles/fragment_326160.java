@interface Life : NSObject

- (void) goThroughTheDay;

- (void) goToWork; // Abstract
- (void) eatLunch; // Abstract
- (void) comeBackHome; // Abstract
- (void) programABitMore; // Abstract

@end

@implementation Life

- (void) goThroughTheDay {

    [self goToWork];
    [self eatLunch];
    [self comeBackHome];
    [self programABitMore];
}

- (void) goToWork { [self doesNotRecognizeSelector:_cmd]; }
- (void) eatLunch { [self doesNotRecognizeSelector:_cmd]; }
- (void) comeBackHome { [self doesNotRecognizeSelector:_cmd]; }
- (void) programABitMore { [self doesNotRecognizeSelector:_cmd]; }

@end