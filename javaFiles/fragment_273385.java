while(l<r){
            if(nums[i]+nums[l]+nums[r]==target){
                lst.add(nums[i]);
            //lst.add(l);
            //lst.add(r);
            }

            else if(nums[i]+nums[l]+nums[r]<target)
                l++;
            else
                r--;

        }