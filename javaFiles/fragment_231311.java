@Override
public IBlockState getStateFromMeta(int meta) {
    return getDefaultState().withProperty(FACING, meta == 0 ? EnumFacing.WEST : EnumFacing.EAST);
}

@Override
public int getMetaFromState(IBlockState state) {
    EnumFacing facing = (EnumFacing) state.getValue(FACING);
    return facing.getHorizontalIndex();
}