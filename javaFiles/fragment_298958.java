coins = 1000

while (coins > 0)
{
     input wager
     if wager > coins
         wager = coins
     if wager <= 0
         exit

     slot1 = rand(0..9)
     slot2 = rand(0..9)
     slot3 = rand(0..9)

     if (slot1 == slot2 and slot2 == slot3)
         coins = coins + (100 * wager)
     else if (slot1 == slot2 or slot2 == slot3 or slot1 == slot3)
         coins = coins + (10 * wager)
     else
         coins = coins - wager
}

You're broke ... sorry