module MyModule where


data Strategy  = Strategy {
    fooWithStrategy :: Double -> Double
  , barWithStrategy :: Int -> Int
  , nooWithStrategy :: [Int] -> [Int]
  }

defaultStrategy :: Strategy
defaultStrategy = Strategy { 
    fooWithStrategy = (*2)
  , barWithStrategy = (+2)
  , nooWithStrategy = id
  }

foo :: Double -> Double
foo = fooWithStrategy defaultStrategy

bar :: Int -> Int
bar = barWithStrategy defaultStrategy

noo :: [Int] -> [Int]
noo = nooWithStrategy defaultStrategy

tripleStrategy :: Strategy
tripleStrategy = Strategy {
    fooWithStrategy = (*3)
  , barWithStrategy = (*3)
  , nooWithStrategy = \x -> x ++ x ++ x
  }

customAddStrategy :: Int -> Strategy
customAddStrategy n = Strategy {
    fooWithStrategy = (+ (fromIntegral n))
  , barWithStrategy = (+ n)
  , nooWithStrategy = (n :)
  }