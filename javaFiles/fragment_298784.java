if(!flag && actor.pos.getAbsPoint().distance(point3d) < 10000D && (actor instanceof TypeBomber) && actor.getArmy() != myArmy)
        {
            if (renderedCount < 20)
                {
                Random random = new Random();
                int k = random.nextInt(500);
                int l = k - 250;
                k = random.nextInt(500);
                int i1 = k - 250;
                Eff3DActor.New(this, null, new Loc(l, i1, 0.0D, 0.0F, 90F, 0.0F), 1.0F, "Effects/Smokes/CityFire.eff", 600F);
                int j1 = random.nextInt(10);
                wait = (float)(1.0D + (double)j1 * 0.10000000000000001D);
                renderedCount += 1;
            }
            flag = true;
        }