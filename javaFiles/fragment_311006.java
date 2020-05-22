function s = generateJavaFormatedMatrix( A, sigdigs, name )
if nargin < 2
    sigdigs = 15;
end
format  = [ '%+1.', int2str(sigdigs), 'e' ]; 
s       = sprintf( 'final double [][] %s = {\n', name ); 
for row = 1:size(A,1)
    s   = [ s, '    { ' ];
    for col = 1:size(A,2)
        s   = [ s, num2str( A(row,col), format ) ];
        if ( col ~= size(A,2) )
            s   = [ s, ', ' ];
        end
    end
    if row == size(A,1)
        s   = sprintf( [ s, ' } \n' ] );
    else 
        s   = sprintf( [ s, ' }, \n' ] );
    end
end
s   = [ s, '};' ];