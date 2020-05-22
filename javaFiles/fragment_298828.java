rule "check-multiple instance-on-cover-type" extends "base"
when
accumulate ( $b: BasePriceUpchargeConfig( 
             prefix contains $prefix,
             style contains $style,
             $baseCoverType : baseCoverType  )
             and
             $c : CoverUpChargeConfig( 
             baseCoverType contains $baseCoverType.get(0),
             gradeOrder contains $grade,
             prefix  contains $prefix,
             style  contains $style );
            $collectList1 : collectList($b)
            $collectList : collectList($c) )