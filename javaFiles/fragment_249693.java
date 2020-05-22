/*
 * Created on 07.04.2012
 */

/**
 * This class implements some functions as static class methods.
 *
 * (c) Copyright 2012 Christian Fries.
 *
 * @author Christian Fries
 * @version 1.0
 */
public class SpreadsheetFunctions {

    /**
     * Re-implementation of the Excel PRICE function (a rather primitive bond price formula).
     * The reimplementation is not exact, because this function does not consider daycount conventions.
     * We assume we have (int)timeToMaturity/frequency future periods and the running period has
     * an accrual period of timeToMaturity - frequency * ((int)timeToMaturity/frequency).
     * 
     * @param timeToMaturity The time to maturity.
     * @param coupon Coupon payment.
     * @param yield Yield (discount factor, using frequency: 1/(1 + yield/frequency).
     * @param redemption Redemption (notional repayment).
     * @param frequency Frequency (1,2,4).
     * @return price Clean price.
     */
    public static double price(
            double timeToMaturity,
            double coupon,
            double yield,
            double redemption,
            int frequency)
    {
        double price = 0.0;

        if(timeToMaturity > 0) {
            price += redemption;
        }

        double paymentTime = timeToMaturity;
        while(paymentTime > 0) {
            price += coupon/frequency;

            // Discount back
            price = price / (1.0 + yield / frequency);
            paymentTime -= 1.0 / frequency;
        }

        // Accrue running period
        double accrualPeriod = 0.0-paymentTime; // amount of running period which lies in the past (before settlement)
        price *= Math.pow(1.0 + yield / frequency, accrualPeriod*frequency);
        price -= coupon/frequency * accrualPeriod*frequency;

        return price;
    }
}