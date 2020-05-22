%Rules:
%1. If there are 2 or 3 or 4 consecutive positive numbers, then 0.5 point
%2. If there are five or more consecutive positive numbers, then 1.0 point
%3.  And if there isn't any consecutive positive number, for example: 
%   0 0 0 6 0 0, then 0.0 point. (ignore it, consider that positive 
%   number as zero)
%4. if there is only one zero in the middle of positive integers = ignore 
%   that zero (consider it as a positive integer)
%5. If there are two or more consecutive 0, THEN no point.

%testData = [0 30 43 54 0 0 0 41 54 14 10 1 0 0 0 0 32 41 98 12 0 0 0 1 2 0 1 2 0 ];
testData = [30 43 54 0 0 0 41 54 14 10 1 0 0 0 0 32 41 98 12 0 0 0 ];
posa = testData>0;
%add 0s at each end so that the diffs at the ends work.
diffa = diff([0 posa 0])
starts = find(diffa ==1)
ends = find(diffa==-1)

% Rule 4 if any end (-1) is immediately followed by a start, that means that there 
%   is a 0 in the middle of a run.  substitute a 1 in the position and recalc.
midZeroLengths = starts(2:end) - ends(1:(end-1));
%pad to account for the fact that we only compared part.
midZeroLengths = [midZeroLengths 0];
if any(midZeroLengths == 1);
    testData(ends(midZeroLengths==1)) = 1;
    posa = testData>0;
    %add 0s at each end so that the diffs at the ends work.
    diffa = diff([0 posa 0])
    starts = find(diffa ==1)
    ends = find(diffa==-1)  
end

runs = ends-starts
halfs = (runs > 1) & (runs < 5)
wholes = (runs > 4)
final = sum(halfs)*0.5 + sum(wholes)